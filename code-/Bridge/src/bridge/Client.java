package bridge;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HandsetBrand ab;
        ab = new HandsetBrandN();

        ab.SetHandsetSoft(new HandsetGame());
        ab.Run();

        ab.SetHandsetSoft(new HandsetAddressList());
        ab.Run();

        ab = new HandsetBrandM();

        ab.SetHandsetSoft(new HandsetGame());
        ab.Run();

        ab.SetHandsetSoft(new HandsetAddressList());
        ab.Run();
	}

}
