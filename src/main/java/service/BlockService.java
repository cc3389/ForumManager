package service;

import java.util.List;

import dao.BlockDao;
import dao.PostDao;
import entirety.Block;
import entirety.Post;

public class BlockService {
	private BlockDao bd;
	private PostDao pd;
	public BlockService() {
		bd = new BlockDao();
		pd = new PostDao();
	}
	public boolean add(Block block) {
		boolean isAdd = bd.addBlock(block);
		return isAdd;	
	}
	public boolean del(String ID) {		
		List<Post> posts = pd.queryPostByBlockID(ID);
		PostsService ps = new PostsService();
		for (int i = 0; i <posts.size(); ++i) {
			ps.delPost(posts.get(i).getPostID());
		}
		boolean isdel = bd.delBlockByID(ID);
		return isdel;
	}
}
