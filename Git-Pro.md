Git Pro
---

## Getting Started
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

## Git Basics
```git
git init
git clone [-b <name>] <repository> [<directory>]
git status [-s|--short]
git diff [--cached]
git rm [--cached] [-n] [-r] <file>...
git add <file>...
git commit [-a] [-m <msg>] [--amend]
```

## Recording Changes to the Repository
在 Git 版本控制下的文件生命周期：

![images](images/git/lifecycle.png)

## Ignoring Files
可以创建一个名为 `.gitignore` 的文件，来列出要忽略的文件模式。文件 `.gitignore` 的格式规范如下：
- 空行或者以 `#` 开头的行都会被忽略
- 可以使用标准的 Glob 匹配模式
- 可以使用 `/` 开始来防止递归
- 可以使用 `/` 结尾来指定目录
- 可以使用 `!` 来取反指定模式（即不忽略指定模式的文件或目录）

`Glob` 模式是指 shell 中所使用的简化的正则表达式。`*` 匹配零个或多个字符；`[abc]` 匹配 a、b、c 中的任意字符；`[0-9]` 匹配 0 到 9 的任意数字；`?` 匹配任意的单个字符；两个 `*` 匹配任意的中间目录，例如 `a/**/z` 可以匹配 `a/b/z` 或 `a/b/c/z`。

```txt
# ignore all .a files
*.a

# but do track lib.a, even though you're ignoring .a files above
!lib.a

# only ignore the TODO file in the current directory, not subdir/TODO
/TODO

# ignore all files in the build/ directory
build/

# ignore doc/notes.txt, but not doc/server/arch.txt
doc/*.txt

# ignore all .pdf files in the doc/ directory and any of its subdirectories
doc/**/*.pdf
```

## Viewing the Commit History
```git
git log -- <path>...

git log [-<number>|-n <number>|--max-count=<number>] [--skip=<number>] [--since=<date>] [--after=<date>] [--until=<date>] [--before=<date>] [--author=<pattern>] [--committer=<pattern>] [--grep=<pattern>] [--all] [--branches=<pattern>] [--tags=<pattern>]

git log [--pretty|--format=<format>] [--oneline|--pretty=oneline --abbrev-commit] [--encoding=<encoding>] [--graph]
```