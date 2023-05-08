package servletPackage;

public class History {
	private String ID;
	private String X_COORDINATE;
	private String Y_COORDINATE;
	private String INQUERY_DATE;
	
	public History(String ID, String x_COORDINATE, String y_COORDINATE, String INQUERY_DATE) {
		this.ID = ID;
		this.X_COORDINATE = x_COORDINATE;
		this.Y_COORDINATE = y_COORDINATE;
		this.INQUERY_DATE = INQUERY_DATE;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getX_COORDINATE() {
		return X_COORDINATE;
	}
	public void setX_COORDINATE(String x_COORDINATE) {
		this.X_COORDINATE = x_COORDINATE;
	}
	public String getY_COORDINATE() {
		return Y_COORDINATE;
	}
	public void setY_COORDINATE(String y_COORDINATE) {
		this.Y_COORDINATE = y_COORDINATE;
	}
	public String getINQUERY_DATE() {
		return INQUERY_DATE;
	}
	public void setINQUERY_DATE(String iNQUERY_DATE) {
		this.INQUERY_DATE = iNQUERY_DATE;
	}
}
