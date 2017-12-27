package com.drpicox.blog.denuncies;

import com.drpicox.blog.users.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Denuncia {

    @Id
    @GeneratedValue
    private Long id;

    private String reason;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User reporter;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User reported;

    public Denuncia(Long id, User reporter, User reported, String reason) {
        this.id = id;
        this.reason = reason;
        this.reporter = reporter;
        this.reported = reported;
    }

    @JsonCreator
    public Denuncia(
        @JsonProperty("id") Long id,
        @JsonProperty("reporterId") Long reporterId,
        @JsonProperty("reportedId") Long reportedId,
        @JsonProperty("reason") String reason) {
        this(id, User.withId(reporterId), User.withId(reportedId), reason);
    }

    @JsonValue
    public Map getJsonObject() {
        Map result = new LinkedHashMap();
        result.put("id", id);
        result.put("reporterId", reporter != null ? reporter.getId() : null);
        result.put("reportedId", reported != null ? reported.getId() : null);
        result.put("reason", reason);
        return result;
    }

    public Long getId() {
        return id;
    }

    Denuncia() {
    }
}
