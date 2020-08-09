import org.apache.http.impl.client.CloseableHttpClient;

import com.enixlin.policydocument.controller.UpdateController;
import com.enixlin.policydocument.service.NetService;

public class PolicyDocument {

	public static void main(String[] args) {
		System.out.println("app run start");
		// 初始化程序,后成升级控制器对象
		UpdateController uc = new UpdateController();
		uc.test();
		//检查远程服务器是否有升级包
//		if (uc.checkRemoteUpdatePackage()) {
//			//获取升级包信息
//
//		}

	}

}
