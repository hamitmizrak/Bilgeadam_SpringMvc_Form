package com.bilgeadam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubScriberDto implements Serializable {
    private static final long serialVersionUID = -3360448772371562988L;

    private int subScriberId;
    private String subScriberName;
    private String subScriberSurname;
    private String subScriberAddress;
    private String subScriberEmailAddress;
    private Date creationDate;

}
