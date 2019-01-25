public class InvoiceTest {
	public static void main(String[] args) {
		
		String partNumber = "PN-123-456-789";
		String partDesc = "Mazda 3 engine piston";
		int quantity = 3;
		double price = 33.33;
		Invoice invoice1 = new Invoice(partNumber, partDesc, quantity, price);
		printInvoice(invoice1);
		
		System.out.println();
		System.out.println("Setting a new part number to invoice1");
		invoice1.setPartNumber("PN-000-000-000");
		printInvoice(invoice1);
		
		System.out.println();
		System.out.println("Setting a new part description to invoice1");
		invoice1.setPartDescription("A new part description");
		printInvoice(invoice1);
		
		System.out.println();
		System.out.println("Attempting to set a negative quantity (-10) to invoice1");
		invoice1.setQuantity(-10);
		printInvoice(invoice1);

		System.out.println();
		System.out.println("Setting quantity 5 to invoice1");
		invoice1.setQuantity(5);
		printInvoice(invoice1);
		
		System.out.println();
		System.out.println("Attempting to set a negative price (-10.5) to invoice1");
		invoice1.setPrice(-10.5);
		printInvoice(invoice1);

		System.out.println();
		System.out.println("Setting price 55.55 to invoice1");
		invoice1.setPrice(55.55);
		printInvoice(invoice1);
		
	}
	
	private static void printInvoice(Invoice invoice) {
		System.out.println("INVOICE CONTENTS:");
		System.out.printf("Part number : %s%n", invoice.getPartNumber());
		System.out.printf("Part description : %s%n", invoice.getPartDescription());	
		System.out.printf("Quantity : %d%n", invoice.getQuantity());
		System.out.printf("Item Price : %.2f%n", invoice.getPrice());
		System.out.printf("Invoice Amount : %.2f%n", invoice.getInvoiceAmount());
		System.out.println();
	}
}

