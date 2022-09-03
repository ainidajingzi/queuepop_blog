package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;

import java.util.Date;

/**
 * Entity基类
 *
 * @author wangchong
 * @date 2022/9/3 16:17
 */
@Data
public class SuperEntity<T extends Model> extends Model {

    /**
     *
     */
    private static final long serialVersionUID = -4851055162892178225L;

    /**
     * 唯一UID
     */
    @TableId(value = "uid", type = IdType.UUID)
    private String uid;

    /**
     * 状态 0：失效  1：生效
     */
    private int status;

    /**
     * @TableField 配置需要填充的字段
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public SuperEntity() {
        this.status = EStatus.ENABLE;
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
