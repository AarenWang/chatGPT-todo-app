import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.time.LocalDateTime;

public class Task {

    private Long id;
    private String name;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private TaskStatus status;

    // Constructor, getters, and setters omitted for brevity

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }

    // MyBatis annotations for mapping Task to database table
    @MappedJdbcTypes(JdbcType.BIGINT)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @MappedJdbcTypes(JdbcType.VARCHAR)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MappedJdbcTypes(JdbcType.TIMESTAMP)
    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    @MappedJdbcTypes(JdbcType.TIMESTAMP)
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @MappedJdbcTypes(JdbcType.VARCHAR)
    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
