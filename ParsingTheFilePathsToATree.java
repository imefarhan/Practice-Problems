package Personal;

import java.util.LinkedList;

//INCOMPLETE
//TO BE COMPLETED LATER...

public class ParsingTheFilePathsToATree {
	
	static Node root;
	
	static class Node
	{
		String name;
		LinkedList<Node> folder;
		LinkedList<String> files;
		
		void addFolder(String folderName)
		{
			if(!folder.contains(folderName))
			{
				folder.add(new Node(folderName));
			}
		}
		
		void addFile(String FileName)
		{
			if(!files.contains(FileName))
			{
				files.add(FileName);
			}
		}
		
		Node(String FolderName)
		{
			name = FolderName;
			folder = null;
			files = null;
		}
		
		boolean containsFolder(String FolderName)
		{
			if(folder.contains(FolderName))
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args) {

		String path1 = "/mnt/sdcard/folder1/a/b/file1";
		String path2 = "/mnt/sdcard/folder1/a/b/file2";
		String path3 = "/mnt/sdcard/folder2/e/c/file3";
		String path4 = "/mnt/sdcard/file9";
		
		String path[] = path1.split("/");
		
		addToTree(path);
	}

	private static void addToTree(String[] path) {

		if(root==null)
		{
			root = new Node(".");
		}
		
		for(int i=1; i<path.length-2; i++)
		{
			root.addFolder(path[i]);
		}
		
		
		
	}

}
