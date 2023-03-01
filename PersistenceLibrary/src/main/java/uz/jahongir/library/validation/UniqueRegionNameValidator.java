package uz.jahongir.library.validation;

import lombok.RequiredArgsConstructor;
import uz.jahongir.library.repositories.RegionRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueRegionNameValidator implements ConstraintValidator<UniqueRegionName, String > {
    private final RegionRepository regionRepository;


    @Override
    public boolean isValid(String regionName, ConstraintValidatorContext context) {
        boolean existsByName = regionRepository.existsByName(regionName);
        return !existsByName;
    }
}
