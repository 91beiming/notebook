package com.beiming.notebook.service.model;

import com.beiming.notebook.common.response.R;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * YiDengReponse
 */
@Setter
@Getter
@ToString
public class YiDengResponse<T> extends R<T> {

    private String msg;
    private String success;

}
