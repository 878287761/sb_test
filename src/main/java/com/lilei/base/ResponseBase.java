package com.lilei.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 *服务接口有响应  统一规范响应服务接口信息
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBase implements Serializable {

    private Integer Code;
    private String msg;
    private Object data;
}
