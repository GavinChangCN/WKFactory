package WKFactory.Factory;

import WKFactory.Facade.BllFacade;
import WKFactory.Interface.BllInterface;

public class BllFacadeFactory {

	// 单例
	private static BllFacadeFactory objbllFactory = new BllFacadeFactory();

	private BllFacadeFactory() {
	}

	public static BllFacadeFactory getbBllFactoryInstance() {

		return objbllFactory;
	}

	// bllinterface调用单例

	public BllInterface getInterface() {
		BllInterface bllInterface = BllFacade.getBllFacadeInstance();

		return bllInterface;
	}
}
