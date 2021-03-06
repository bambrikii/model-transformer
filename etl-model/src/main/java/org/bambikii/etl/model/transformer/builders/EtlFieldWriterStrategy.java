package org.bambikii.etl.model.transformer.builders;

import org.bambikii.etl.model.transformer.adapters.EtlFieldLoadable;

import static org.bambikii.etl.model.transformer.builders.EtlFieldReaderStrategy.*;

public abstract class EtlFieldWriterStrategy<T> {
    public EtlFieldLoadable<T, ?> createOne(String name, String type) {
        switch (type) {
            case STRING:
                return getStringWriter(name);
            case INT:
                return getIntWriter(name);
            case DOUBLE:
                return getDoubleWriter(name);
            default:
                return getMoreWriter(name, type);
        }
    }

    protected abstract EtlFieldLoadable<T, String> getStringWriter(String name);

    protected abstract EtlFieldLoadable<T, Integer> getIntWriter(String name);

    protected abstract EtlFieldLoadable<T, Double> getDoubleWriter(String name);

    protected <O> EtlFieldLoadable<T, O> getMoreWriter(String name, String type) {
        throw new IllegalStateException("Unexpected value: " + name + ", " + type);
    }
}