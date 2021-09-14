package fatec.sp.gov.tecnocode.service;

import fatec.sp.gov.tecnocode.validator.Operation;

public interface GenericService<T> {
    T save(T t, Operation operation);

    void delete(final Long id);
}