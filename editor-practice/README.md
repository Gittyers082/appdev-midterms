# Editor practice: Module 4 (Sublime Text + Notepad++)

Do these in order:

1. `1-regex-practice.txt`: regex find & replace in Sublime (12 tasks)
2. `2-multicursor-practice.txt`: multiple cursors, line shortcuts, Goto Anything, split window
3. `3-macro-practice.txt`: macros in Notepad++
4. `snippets/`: Sublime snippets (see below)

Answers are in `ANSWERS.md`. Try each task before you look.

## Installing the snippets

1. In Sublime: **Preferences > Browse Packages...** and open the **User** folder.
2. Copy the three `.sublime-snippet` files from `snippets/` into it.
3. Open any `.java` file:
   - `header` + Tab: snippet **with** a tab trigger, using environment variables
   - select some code, **Ctrl+Shift+P**, then "Snippet: Wrap in try-catch": snippet **without** a tab trigger
   - `sout.sublime-snippet` is an exercise: finish it yourself, save it, and test it

You can also make one from scratch: **Tools > Developer > New Snippet...**, then save it in `Packages/User` with the `.sublime-snippet` extension.

### Snippet parts

| Part | Meaning |
|---|---|
| `<content><![CDATA[ ... ]]></content>` | The text that gets inserted |
| `<tabTrigger>` | Word you type before pressing Tab (optional: leave it out for no trigger) |
| `<scope>` | Where it works, e.g. `source.java`, `text.html` |
| `<description>` | Name shown in the Command Palette / Tools > Snippets |
| `$1`, `$2` | Tab stops (Tab jumps through them in order) |
| `${1:default}` | Tab stop with placeholder text |
| `$0` | Where the cursor ends up last |

### Environment variables in snippets

| Variable | Gives you |
|---|---|
| `$TM_FILENAME` | Name of the current file |
| `$TM_FILEPATH` | Full path of the current file |
| `$TM_FULLNAME` | The user's name |
| `$TM_LINE_NUMBER` | Current line number (starts at 1) |
| `$TM_LINE_INDEX` | Current column (starts at 0) |
| `$TM_CURRENT_LINE` | Text of the current line |
| `$TM_CURRENT_WORD` | Word under the cursor |
| `$TM_SELECTED_TEXT` / `$SELECTION` | The selected text |
| `$TM_TAB_SIZE` | Tab size setting |
| `$TM_SOFT_TABS` | `YES` if spaces are used instead of tabs |

## Regex cheat sheet

| Pattern | Matches |
|---|---|
| `.` | Any character |
| `\d` `\w` `\s` | Digit / word char (letter, digit, `_`) / whitespace |
| `\D` `\W` `\S` | The opposites |
| `[abc]` `[^abc]` `[a-z]` | One of / none of / range |
| `*` `+` `?` | 0+ / 1+ / 0 or 1 |
| `{3}` `{2,5}` `{2,}` | Exactly 3 / 2 to 5 / 2 or more |
| `*?` `+?` | Lazy: match as LITTLE as possible |
| `^` `$` | Start / end of line |
| `\b` | Word boundary |
| `( )` | Capture group, reused in Replace as `$1` / `\1` |
| `a\|b` | a or b |
| `\.` `\(` `\$` | Escape special characters to match them literally |
