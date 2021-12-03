package entirety;
/**
 * 板块实体
 * @author cc3389
 *
 */
public class Block {
	private String blockID;
	private String type;
	private String superAdminID;
	public Block() {
		
	}
	@Override
	public String toString() {
		return "Block [blockID=" + blockID + ", type=" + type + ", superAdminID=" + superAdminID + "]";
	}
	public String getBlockID() {
		return blockID;
	}
	public void setBlockID(String blockID) {
		this.blockID = blockID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSuperAdminID() {
		return superAdminID;
	}
	public void setSuperAdminID(String superAdminID) {
		this.superAdminID = superAdminID;
	}
	public Block(String blockID, String type, String superAdminID) {
		this.blockID = blockID;
		this.type = type;
		this.superAdminID = superAdminID;
	}
	
}
