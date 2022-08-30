package com.guocz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author guocz
 * @date 2022/8/30 14:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MinIoUploadResDTO implements Serializable {

    private static final long serialVersionUID = 475040120689218785L;

    private String minFileName;

    private String minFileUrl;

}
