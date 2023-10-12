package co.project.prjdb.notice.service;

import lombok.Data;

@Data
public class ItemVO {
	private String itemId;
	private String itemName;
	private String itemScript;
	private int itemPrice;
	private int itemSalePrice;
	private int itemStar;
	private String itemImg;
}
