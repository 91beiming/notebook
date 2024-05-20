package com.beiming.notebook.service.model;

import com.beiming.notebook.common.entity.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * FileEntity
 */
@Setter
@Getter
public class ImageDTO extends BaseObject {

    private String originFilename;

    private String path;

    private String thumbPath;

}
