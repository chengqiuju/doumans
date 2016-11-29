package douman.app.cailutong.com.douman.interfaces;

/**
 * app管理接口，负责需要跨activity实现功能
 * 1完全退出应用方法
 *2 进入用户中心方法
 * @author hammerCui
 *
 */
public interface AppManagerInterface {

	/**
	 * 回调退出
	 */
	public void CallQuit();

	/**
	 * 进入用户中心
	 */
	public void CallIntoMemberCenter();
}
