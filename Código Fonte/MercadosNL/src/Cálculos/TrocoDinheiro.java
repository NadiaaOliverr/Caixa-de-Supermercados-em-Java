/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cálculos;

/**
 *
 * @author Nádia Oliveira
 */
public class TrocoDinheiro {
    static float  troco=-1;
    public static float Troco(float preco_total, float preco_passado)
    {        
        troco = preco_passado - preco_total;
        return troco;
    }
    public static float RetornoTroco()
    {
        return troco;
    }
}
