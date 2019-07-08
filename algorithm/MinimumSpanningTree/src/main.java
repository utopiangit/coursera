
public class main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		UnionFind uf = new UnionFind(6);
		uf.unite(0, 2);
		uf.unite(1, 3);
		uf.unite(3, 5);
		System.out.println(uf.same(1, 4));
		System.out.println(uf.same(1, 5));

	}

}
