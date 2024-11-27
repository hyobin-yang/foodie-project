package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberMission is a Querydsl query type for MemberMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberMission extends EntityPathBase<MemberMission> {

    private static final long serialVersionUID = 263768240L;

    public static final QMemberMission memberMission = new QMemberMission("memberMission");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<umc.study.domain.enums.MissionStatus> status = createEnum("status", umc.study.domain.enums.MissionStatus.class);

    public QMemberMission(String variable) {
        super(MemberMission.class, forVariable(variable));
    }

    public QMemberMission(Path<? extends MemberMission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberMission(PathMetadata metadata) {
        super(MemberMission.class, metadata);
    }

}

