package me.motyim.lean.DemoGraphQL.model;

import lombok.Data;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 1/16/2019
 */
@Data
public class Info {
    private String description;
    private String version;
    private String title;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private String licenseName;
    private String licenseUrl;
}
