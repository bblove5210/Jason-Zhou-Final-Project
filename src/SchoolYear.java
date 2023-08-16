public enum SchoolYear {
	FRESHMAN,
	SOPHOMORE,
	JUNIOR,
	SENIOR;
	
	public String toString() {
		switch(this) {
			case FRESHMAN:
				return "Freshman";
			case SOPHOMORE:
				return "Sophomore";
			case JUNIOR:
				return "Junior";
			case SENIOR:
				return "Senior";
			default:
				return null;
		}
	}
}