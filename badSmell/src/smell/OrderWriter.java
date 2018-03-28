package smell;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

public class OrderWriter {

	// writes this order object to the specified print writer
	public void writeOrder(Order order, PrintWriter pw) {
		// get a vector of line items
		Vector lineItems = order.getLineItemList().getLineItems();

		// create an iterator for the vector
		Iterator iter = lineItems.iterator();
		lineItem item;
		while (iter.hasNext()) {
			item = (lineItem) iter.next();

			// calculate total for line item
			int unitPrice = item.getUnitPrice();
			int qty = item.getQuantity();
			int productID = item.getProductID();
			int imageID = item.getImageID();
			int lineitemtotal = unitPrice * qty;

			pw.println("Begin Line Item");
			pw.println("Product = " + productID);
			pw.println("Image = " + imageID);
			pw.println("Quantity = " + qty);
			pw.println("Total = " + lineitemtotal);
			pw.println("End Line Item");
		}
		pw.println("Order total = " + order.getTotal());
	}

}
