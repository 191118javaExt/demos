# Git

Git is a source code management system that can save snapshots of your project on one or more branching paths.

- Category of tools for managing source code for a team
- Provides means to rollback to previous versions
- Has features for resolving merge conflicts
- Used to track changes in the repository

## Glossary

- **Repository**: Files, folders, objects, and branches representing a project, managed within a `.git` folder
- **Working Directory**: Currently active project files and folders.
- **Staging Area**: Area between Working Directory and Repository where project changes are added before the next commit.
- **Commit**: Snapshot of staged changes from a working directory.
- **Branch**: Named pointer to a commit in git history.
- **Head**: Special pointer to the current branch.
- **Remote**: Link to synchronized external repository, usually on a service like GitHub.
- **.gitignore**: Text file listing what to ignore when moving working directory files into staging.

## Idea

Git tracks changes to source code in individual files. Supports creating multiple branches, each with separate changes before ultimately merging back together. This eases development with multiple people on the same project. There is always a `master` branch, but there is also commonly a `dev` branch where most of the devlopment is merged into first. Developers would branch off of `dev`, and then merge back into it. One developer would work on feature A on one branch, which may require changes on multiple files. A second developer would work on feature B on a second branch, also across multiple files. Lets say feature A finishes first so they merge their code with the `dev` branch. Developer B would pull changes from the `dev` branch, resolving any merge conflicts. Once feature B is complete, it would also be merged into `dev`. So on and so forth.

## Flow

After a project is initialized, it moves between uncommitted, staged, and committed phases.

    # Initialize a git project
    git init

    # Add all new and modified changes to staging
    git add .

    # Commit staged changes
    git commit -m "a commit message"

## Remote Repositories

Cloud services like GitHub, GitLab, and BitBucket host git servers which can be synchronized with local repositories. When an existing project on these services is cloned, its `.git` directory will include a remote link to the original project, commonly known as `origin`.

A local repository can also be synchronized in the opposite direction, copying a local project to an empty repository on a cloud server.

    # Create remote link named 'origin'
    git remote add origin <url>

    # Push local master branch to origin master branch
    git push origin master

### Some Commands

- Configure credentials
  1. `git config --global user.name <name>`
  2. `git config --global user.email <email>`
- 2 ways to create local repository
  1. `git clone <url>` (url is from git service remote repository)
  2. Three steps:
        1. `git init` (turns directory into git repo)
        2. `git remote add <remoteName> <url>` (links local repo to remote)
            - Note, `<remoteName>` is `origin` by default
        3. `git pull <remoteName> <branch>`
- Pushing changes
  1. `git add <filename>` or `git add .` or `git add *`
  2. `git commit -m "message"`
  3. `git push <remoteName> <branch>`
- Creating a branch
  - `git checkout -b <branch>`
  - `git branch <branch>`
- Deleting a branch
  - `git branch -d <branch>`
- View branches
  - `git branch`
- Merging
  1. `git checkout <branch>` (branch merging **into**)
  2. `git pull <remoteName> <branch>` or `git merge <branch>` (branch merging **from**)

## Installation

You can download from this [link](https://git-scm.com/downloads).

### Windows

This installation can also provide a unix-based command line interface called `git bash`. If you have no other preferred terminals, this is a good choice.

### Linux & Mac

`git bash` is not needed as there is already a unix-based terminal available.
