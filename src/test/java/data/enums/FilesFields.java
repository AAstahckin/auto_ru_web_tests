package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FilesFields {

    PHOTO_WARNING_TEXT("Мы не распознали госномер на фото. Проверьте, что он виден хотя бы на одном снимке, иначе объявление может быть заблокировано.");

    final String value;

}
