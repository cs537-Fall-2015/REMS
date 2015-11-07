<<<<<<< HEAD
git clone https://github.com/cs537-Fall-2015/REMS.git
git push origin master
git fetch origin master


git status
git add testfile.txt
git add testfilefile1.txt
git add -A
git status
git commit -m "any msg"
git push -u origin master
git pull  


List the contents of the current directory (folder): 
ls

Switch from the current branch to the indicated branch:
$ git checkout BranchName

Merge the specified branch into the current branch and auto-commit the results: 
$ git merge BranchName

Merge the specified branch into the current branch and do not commit the results: 
$ git merge BranchName --no-commit

Undo everything since the last commit: 
$ git reset --hard

Remove the specified file from the current directory (no spaces): 
$ rm DeleteFileName

Removes the specified folder and all contents: 
$ rm -rf DeleteFolderName

adds all changes to tracked files and all file removals to the next commit, but does not add new files
$ git add -u  ($ git add .   OR   $ git add -A)

List all local branches:
$ git branch

List all local and remote branches:
$ git branch -a
=======
To Run the Client - Server Communication
The program is set to run on localhost port 3656

1) Run FRemsserv.java from src>REMS>FRemsserv.java
2) Run REMS_Testmain.java from src>REMS>REMS_testFramework>REMS_Testmain.java
3) Enter one of the following commands:
	3.1) maxspeed
	3.2) minspeed
	3.3) speed
>>>>>>> 39d3f4ea6d7273cc45521d05b6114e64233639c7
