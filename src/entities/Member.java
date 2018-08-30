/*
 * Member Class
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 */

package entities;

public class Member {
	private String memberCode;
	private String memberType;
	private Person primaryContact;
	private String memberName;
	private Address memberAddress;

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		if (memberCode.length() > 0) {
			this.memberCode = memberCode;
		} else {
			System.out.println("Member code is too short.");
			System.exit(1);
		}
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		if (memberType.length() == 1) {
			this.memberType = memberType;
		} else {
			System.out.println("Member type must be a single character.");
			System.exit(1);
		}
	}

	public Person getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(Person primaryContact) {
		if (primaryContact != null) {
			this.primaryContact = primaryContact;
		} else {
			System.out.println("Please enter a valid Primary Contact.");
			System.exit(1);
		}
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		if (memberName.length() > 0) {
			this.memberName = memberName;
		} else {
			System.out.println("Member name is too short.");
			System.exit(1);
		}
	}

	public Address getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(Address memberAddress) {
		if (memberAddress != null) {
			this.memberAddress = memberAddress;
		} else {
			System.out.println("Please enter a valid member address.");
			System.exit(1);
		}
	}

	public Member(String memberCode, String memberType, Person primaryContact, String memberName,
			Address memberAddress) {
		super();
		if (memberCode.length() > 0) {
			this.memberCode = memberCode;
		} else {
			System.out.println("Member code is too short.");
			System.exit(1);
		}
		if (memberType.length() == 1) {
			this.memberType = memberType;
		} else {
			System.out.println("Member type must be a single character.");
			System.exit(1);
		}
		if (primaryContact != null) {
			this.primaryContact = primaryContact;
		} else {
			System.out.println("Please enter a valid Primary Contact.");
			System.exit(1);
		}
		if (memberName.length() > 0) {
			this.memberName = memberName;
		} else {
			System.out.println("Member name is too short.");
			System.exit(1);
		}
		if (memberAddress != null) {
			this.memberAddress = memberAddress;
		} else {
			System.out.println("Please enter a valid member address.");
			System.exit(1);
		}
	}
}
