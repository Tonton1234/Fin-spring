package apii.apii.apii.Services;

import apii.apii.apii.dto.request.AnneeScolaireRequestDto;

public interface serviceRest<T,ID> {
    void add(T dto);
}
