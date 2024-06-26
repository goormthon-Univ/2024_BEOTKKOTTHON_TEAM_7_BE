package groomthon.studymate.entity;

import groomthon.studymate.dto.UserResponseDto;
import groomthon.studymate.entity.tag.Subject;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class User extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Heart> hearts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserStudy> userStudies = new ArrayList<>();


    //추가

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private double score;

    @Column
    private Subject subject;

    //-------------------여기부터 멘토링 속성
    @OneToMany(mappedBy = "user")
    List<Mentoring> mentorings= new ArrayList<>();

    //여기부터 멘토,멘티 속성
    @OneToMany(mappedBy = "user")
    List<Mentor> mentors= new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Mentee> mentees= new ArrayList<>();




    //여기부터 멘티 속성



    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }



    public static UserResponseDto toUserResDto(User user){
        return new UserResponseDto(user.getId(),user.getName(),user.getEmail(), user.getPicture());
    }

}
