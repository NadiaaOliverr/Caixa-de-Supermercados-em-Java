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
    public static float Troco(float preco_total, float preco_passado)
    {
        float troco;
        troco = preco_passado - preco_total;
        return troco;
    }
}
