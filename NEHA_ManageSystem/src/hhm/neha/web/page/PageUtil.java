/**
 * 
 */
package hhm.neha.web.page;


public class PageUtil {
	/**
	 * 记录总数
	 */
	private int count = 0;
	/**
	 * 每页显示记录数
	 */
	private int pageSize = 10;
	/**
	 * 总页数
	 */
	private int pageCount = 0;
	/**
	 * 当前页数
	 */
	private int pageNum = 1;
	
	/**
	 * 下一页
	 */
	private int nextNum;
	
	/**
	 * 上一页
	 */
	private int frontNum;
	
	/**
	 * 首页
	 */
	private int firstNum;
	
	/**
	 * 最后一页
	 */
	private int lastNum;
	
	/**
	 * 是否是首页
	 */
	private boolean hasFirstPage;
	
	/**
	 * 是否最后页
	 */
	private boolean hasLastPage;
	

	/**
	 * @return 记录总数
	 */
	public int getCount() {
		return count;
	}

	/**
	 * 设定记录总数
	 * @param count
	 */
	public void setCount(int count) {
		if(count < 0){
			this.count = 0;
		}else{
			this.count = count;
		}
	}

	/**
	 * @return 每页显示记录数
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页显示数
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		if(pageSize <= 0){
			this.pageSize = 10;
		}else{
			this.pageSize = pageSize;
		}
	}

	/**
	 * @return 获取总页数
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * 设置总页数
	 * @param pageCount
	 */
	public void setPageCount() {
		pageCount = count / pageSize;
		if(count % pageSize != 0 ){
			pageCount ++;
		}
	}

	/**
	 * @return 获取当前页数
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * 设置当前页数
	 * @param page
	 */
	public void setPageNum(int pageNum) {
		if(pageNum <= 0){
			this.pageNum = 1;
		}else{
			this.pageNum = pageNum;
		}
	}
	
	/**
	 * @return 当前页起始数据数
	 */
	public int getStartData(){
		return (this.pageNum - 1) * this.pageSize;
	}

	/**
	 * @return 下一页 页数
	 */
	public int getNextNum() {
		return nextNum;
	}

	/**
	 * 设置下一页数
	 */
	public void setNextNum() {
		if(pageNum < pageCount){
			nextNum = pageNum + 1;
		}else{
			nextNum = pageCount;
		}
	}

	/**
	 * @return 上一页页数
	 */
	public int getFrontNum() {
		return frontNum;
	}

	/**
	 * 设置上一页页数
	 */
	public void setFrontNum() {
		if(pageNum > 1){
			if(pageNum <= pageCount){
				this.frontNum = pageNum - 1;
			}else{
				this.frontNum = pageCount - 1;
			}
		}else{
			frontNum = 1;
		}
	}

	/**
	 * @return 首页页数
	 */
	public int getFirstNum() {
		return firstNum;
	}

	/**
	 * 设置首页页数
	 */
	public void setFirstNum() {
		this.firstNum = 1;
	}

	/**
	 * @return 最后一页页数
	 */
	public int getLastNum() {
		return lastNum;
	}

	/**
	 * 设置最后一页页数
	 */
	public void setLastNum() {
		this.lastNum = pageCount;
	}

	/**
	 * @return 是首页返回true
	 */
	public boolean isHasFirstPage() {
		return hasFirstPage;
	}

	/**
	 * 设置当前页是否是首页
	 */
	public void setHasFirstPage() {
		if(this.pageNum == 1){
			this.hasFirstPage = true;
		}else{
			this.hasFirstPage = false;
		}
	}

	/**
	 * @return 是最后一页返回true
	 */
	public boolean isHasLastPage() {
		return hasLastPage;
	}

	/**
	 * 设置当前页是否是最后一页
	 */
	public void setHasLastPage() {
		if(this.pageNum == this.pageCount || this.pageCount == 0){
			this.hasLastPage = true;
		}else{
			this.hasLastPage = false;
		}
	}

	/**
	 * @param pageNum 当前页
	 * @param pageSize 每页显示数量
	 * @param count 数据总量
	 */
	public PageUtil(int pageNum, int pageSize, int count){
		this.setPageNum(pageNum);
		this.setPageSize(pageSize);
		this.setCount(count);
		this.setPageCount();
		this.setFirstNum();
		this.setFrontNum();
		this.setNextNum();
		this.setLastNum();
		this.setHasFirstPage();
		this.setHasLastPage();
	}

}
