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
public class PrecoTotalCompra {
    
    public static float TotalCompra(int quantidade, float preco,float soma)
    {
        float total = quantidade * preco;
        soma = soma+total;
        return soma;
    }
}
