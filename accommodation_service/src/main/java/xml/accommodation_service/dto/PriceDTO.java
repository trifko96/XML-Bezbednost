package xml.accommodation_service.dto;

import java.util.Date;

import com.eureka.model.eurekamodel.model.Price;

public class PriceDTO {

	private long id;
	private int oneNightPrice;
	private Date fromDate;
	private Date toDate;
	private long accId;
	
	public PriceDTO() {}
	
	public PriceDTO(Price p) {
		this.id = p.getId();
		this.oneNightPrice = p.getOneNightPrice();
		this.fromDate = p.getFromDate();
		this.toDate = p.getToDate();
		this.accId = p.getAccommodation().getAccommodationId();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getOneNightPrice() {
		return oneNightPrice;
	}

	public void setOneNightPrice(int oneNightPrice) {
		this.oneNightPrice = oneNightPrice;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public long getAccId() {
		return accId;
	}

	public void setAccId(long accId) {
		this.accId = accId;
	}
	
	
}
