package entirety;

public class ChangeBlock {
	private String adminID;
	private String blockID;
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getBlockID() {
		return blockID;
	}
	public void setBlockID(String blockID) {
		this.blockID = blockID;
	}
	public ChangeBlock(String adminID, String blockID) {
		super();
		this.adminID = adminID;
		this.blockID = blockID;
	}
	public ChangeBlock() {
		
	}
}
