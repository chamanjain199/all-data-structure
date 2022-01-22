package alldatastructure.tree;

public class BasicTree {

	public static void main(String[] args) {
		TreeNode drink = new TreeNode("Drink");
		TreeNode hot = new TreeNode("Hot");
		TreeNode cold = new TreeNode("Cold");
		TreeNode tea = new TreeNode("Tea");
		TreeNode coffee = new TreeNode("Coffee");
		TreeNode wine = new TreeNode("Wine");
		TreeNode beer = new TreeNode("Beer");
		
		cold.addChild(beer);
		cold.addChild(wine);
		hot.addChild(tea);
		hot.addChild(coffee);
		
		drink.addChild(cold);
		drink.addChild(hot);
		
		System.out.println(drink.printTree(0));


	}
}
