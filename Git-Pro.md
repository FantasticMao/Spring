Git Pro

---

# Getting Started

## Git Basics
- Committed（已提交）：表示数据已经安全地保存在本地数据库中。
- Modified（已修改）：表示文件已经被修改，但还没保存到数据库中。
- Staged（已暂存）：表示在当前版本中，标记了一个已修改文件，使之被包含在下次提交的快照中。

![images](images/git/areas.png)

## First-Time Git Setup
Git 自带一个 `git config` 的工具来帮助设置控制 Git 外观和行为的配置变量。这些变量存储在三个不同的位 置：
- `/etc/gitconfig` 文件：包含系统上每个用户及他们仓库的通用配置。使用 `git config --system` 读写此配置变量。
- `~/.gitconfig` 或 `~/.config/git/config` 文件：针对当前用户。使用 `git config --global` 读写此配置变量。
- `.git/config` 文件：仅针对当前仓库的 Git 目录。

每一个级别覆盖其上一级别的配置，所以 `.git/config` 会覆盖 `/etc/gitconfig` 中的配置。

```git
git config --global user.name FantasticMao
git config --global user.email maomao8017@gmail.com
git config --global core.editor vim

git config -l | --list [--local|--global|--system]
git config -e | --edit
```

---

# Git Basics

## Getting a Git Repository
```git
git init
git clone [-b <name>] <repository> [<directory>]
```

## Recording Changes to the Repository
在 Git 版本控制下的文件生命周期：

![images](images/git/lifecycle.png)