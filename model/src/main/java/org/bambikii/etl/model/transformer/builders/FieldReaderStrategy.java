package org.bambikii.etl.model.transformer.builders;

import org.bambikii.etl.model.transformer.adapters.FieldReaderAdapter;

public abstract class FieldReaderStrategy<T> {
    public static final String STRING = "string";
    public static final String INT = "int";
    public static final String DOUBLE = "double";

    public FieldReaderAdapter<T, ?> createOne(String name, String type) {
        switch (type) {
            case STRING:
                return getStringReader(name);
            case INT:
                return getIntReader(name);
            case DOUBLE:
                return getDoubleReader(name);
            default:
                return getMoreReader(name, type);
        }
    }

    protected abstract FieldReaderAdapter<T, String> getStringReader(String name);

    protected abstract FieldReaderAdapter<T, Integer> getIntReader(String name);

    protected abstract FieldReaderAdapter<T, Double> getDoubleReader(String name);

    protected <O> FieldReaderAdapter<T, O> getMoreReader(String name, String type) {
        throw new IllegalStateException("Unexpected value: " + name + ", " + type);
    }
}