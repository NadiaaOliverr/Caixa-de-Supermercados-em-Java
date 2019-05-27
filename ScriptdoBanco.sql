CREATE IF NOT EXISTS DATABASE MercadosNL;

CREATE TABLE IF NOT EXISTS Nota_Fiscal (
  codigo serial NOT NULL,
  data_nota_fiscal DATE NOT NULL,
  quantidade INTEGER NOT NULL,
  nome_supermercado VARCHAR(40) NOT NULL,
  PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS Funcionario (
  idFuncionario serial NOT NULL,
  Nome VARCHAR(30) NOT NULL,
  Cargo VARCHAR(20) NOT NULL,
  CPF INTEGER  NOT NULL,
  Hora_Entrada TIMESTAMP NOT NULL,
  Hora_Saida TIMESTAMP NOT NULL,
  PRIMARY KEY(idFuncionario)
);

CREATE TABLE IF NOT EXISTS Categoria (
  idCategoria serial NOT NULL,
  Setor VARCHAR(20) NOT NULL,
  PRIMARY KEY(idCategoria)
);

CREATE TABLE IF NOT EXISTS Usuario (
  idUsuario serial NOT NULL,
  Funcionario_idFuncionario serial NOT NULL,
  Usuario VARCHAR(20) NOT NULL,
  Senha VARCHAR(20) NOT NULL,
  PRIMARY KEY(idUsuario),
  INDEX Usuario_FKIndex1(Funcionario_idFuncionario),
  FOREIGN KEY(Funcionario_idFuncionario)
    REFERENCES Funcionario(idFuncionario)
      ON DELETE NO ACTION --Exclui somente o pai sem afetar o(s) registro(s) filhos ou relacionados em outras entidades.
      ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Produto (
  idProduto serial NOT NULL,
  Categoria_idCategoria serial NOT NULL,
  Nome VARCHAR(40) NOT NULL,
  Cod_Barras INTEGER NOT NULL,
  Preco DOUBLE NOT NULL,
  Marca VARCHAR(30) NOT NULL,
  PRIMARY KEY(idProduto),
  INDEX Produto_FKIndex1(Categoria_idCategoria),
  FOREIGN KEY(Categoria_idCategoria)
    REFERENCES Categoria(idCategoria)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Endereco (
  Funcionario_idFuncionario serial NOT NULL,
  Rua VARCHAR(40) NOT NULL,
  Numero_Casa INTEGER NOT NULL,
  Bairro VARCHAR(20) NOT NULL,
  CEP VARCHAR(10) NOT NULL,
  Cidade VARCHAR(30) NOT NULL,
  Estado VARCHAR(20) NOT NULL,
  INDEX Endereco_FKIndex1(Funcionario_idFuncionario),
  FOREIGN KEY(Funcionario_idFuncionario)
    REFERENCES Funcionario(idFuncionario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Endereco_Supermercado (
  Nota_Fiscal_Codigo serial NOT NULL,
  Rua VARCHAR(40) NOT NULL,
  Bairro VARCHAR(20) NOT NULL,
  CEP VARCHAR(10) NOT NULL,
  Cidade VARCHAR(30) NOT NULL,
  Estado VARCHAR(20) NOT NULL,
  INDEX Endereco_Supermercado_FKIndex1(Nota_Fiscal_Codigo),
  FOREIGN KEY(Nota_Fiscal_Codigo)
    REFERENCES Nota_Fiscal(Codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Detalhe_Venda (
  ID_Venda serial NOT NULL,
  Nota_Fiscal_Codigo serial NOT NULL,
  Funcionario_idFuncionario serial NOT NULL,
  Preco_Unitario DOUBLE NOT NULL,
  Preco_Total DOUBLE NOT NULL,
  Quantidade_Produto INTEGER NOT NULL,
  data_detalhe DATE NOT NULL,
  PRIMARY KEY(ID_Venda),
  INDEX Detalhe_Venda_FKIndex1(Funcionario_idFuncionario),
  INDEX Detalhe_Venda_FKIndex2(Nota_Fiscal_Codigo),
  FOREIGN KEY(Funcionario_idFuncionario)
    REFERENCES Funcionario(idFuncionario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Nota_Fiscal_Codigo)
    REFERENCES Nota_Fiscal(Codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Detalhe_Venda_has_Produto (
  Detalhe_Venda_ID_Venda serial NOT NULL,
  Produto_idProduto serial NOT NULL,
  PRIMARY KEY(Detalhe_Venda_ID_Venda, Produto_idProduto),
  INDEX Detalhe_Venda_has_Produto_FKIndex1(Detalhe_Venda_ID_Venda),
  INDEX Detalhe_Venda_has_Produto_FKIndex2(Produto_idProduto),
  FOREIGN KEY(Detalhe_Venda_ID_Venda)
    REFERENCES Detalhe_Venda(ID_Venda)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Produto_idProduto)
    REFERENCES Produto(idProduto)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


