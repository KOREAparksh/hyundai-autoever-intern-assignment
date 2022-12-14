package com.example.hyundaiboot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@IdClass(PushMessageQueQueId.class)
@Table(name = "PUSH_MSG_SENT_QUEUE")
@EqualsAndHashCode
public class PushMessageQueue{
	@Id
	@Column(name = "PUSH_GEN_DT")
	private LocalDateTime generateTime;

//	@Id
//	@ManyToOne
//	@JoinColumn(name = "USER_ID")
//	private User user;
//
//	@Id
//	@ManyToOne
//	@JoinColumn(name = "DEVICE_ID")
//	private DeviceMaster userDevice;

	@Id
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
//	@JoinColumns({
//			@JoinColumn(name = "USER_ID"),
//			@JoinColumn(name = "DEVICE_ID")
//	})
	@JoinColumn(name = "USER_ID" )
	@JoinColumn(name = "DEVICE_ID")
	private UserDevice userDevice;

	@Id
	@ManyToOne
	@JoinColumn(name = "PUSH_MSG_ID")
	private PushMessageMaster pushMessageMaster;

	@Column(name = "SENT_DT")
	private LocalDateTime sentDateTime;

	@Column(name = "SENT_STAT")
	private String sentState;

	@Column(name = "SENT_CNT")
	private int sentCount;
}
