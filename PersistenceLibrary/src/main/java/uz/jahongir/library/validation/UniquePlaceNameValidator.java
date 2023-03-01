package uz.jahongir.library.validation;

import lombok.RequiredArgsConstructor;
import uz.jahongir.library.repositories.PermissionRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniquePlaceNameValidator implements ConstraintValidator<UniquePlaceName, String > {
    private final PermissionRepository permissionRepository;


    @Override
    public boolean isValid(String permissionName, ConstraintValidatorContext context) {
        boolean existsByName = permissionRepository.existsByName(permissionName);
        return !existsByName;
    }
}
