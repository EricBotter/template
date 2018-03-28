package smell;

import java.util.Iterator;
import java.util.Vector;

public class Order {

	private final lineitemlist lineItemList;

	public Order(lineitemlist lis) {
		lineItemList = lis;
	}

	@Override
	public boolean equals(Object aThat) {
		if (this == aThat) return true;
		if (!(aThat instanceof Order)) return false;
		Order that = (Order) aThat;
		return this.lineItemList.equals(that.lineItemList);
	}

	public lineitemlist getLineItemList() {
		return lineItemList;
	}

	public int getTotal() {
		// get a vector of line items
		Vector lineItems = lineItemList.getLineItems();
		// create an iterator for the vector
		Iterator iter = lineItems.iterator();
		lineItem item;
		// set total to zero
		int total = 0;
		while (iter.hasNext()) {
			item = (lineItem) iter.next();
			total += item.getLineTotal();
		}
		return total;
	}
}
