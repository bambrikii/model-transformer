/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bambikii.etl.model.transformer.adapters;

/**
 *
 * @author Alexander_Arakelian
 */
public interface FieldReaderAdapter<T> {

    void readField(T obj, String name);
}
