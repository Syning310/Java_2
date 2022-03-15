package syning.common;


/**
 *   对原来的消息类进行扩展
 *   加入字节数组，存储文件
 *   加入传输文件的来源
 *   加入传输文件的目的地
  */

public class FileMessage extends Message {

	private byte[] fileBytes;  // 存储文件的数组
	private String scource; // 文件的来源地
	private String dest;    // 文件的目的地
	private long fileLen;   // 文件大小

	public long getFileLen() {
		return fileLen;
	}

	public void setFileLen(long fileLen) {
		this.fileLen = fileLen;
	}

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	public String getScource() {
		return scource;
	}

	public void setScource(String scource) {
		this.scource = scource;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
}
