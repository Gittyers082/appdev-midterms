# Answers: try first!

## Regex (Sublime: regex `.*` ON, In selection ON)

| # | Find | Replace | Why |
|---|---|---|---|
| R1 | `\b\d{4}\b` | (find only) | `\b` stops it matching inside 12345 or A2026B |
| R2 | `^(.+), (.+)$` | `$2 $1` | Group 1 = everything before ", ", group 2 = after |
| R3 | `(\d{4})-(\d{2})-(\d{2})` | `$2/$3/$1` | Reorder the three groups |
| R4 | `(\d{4})(\d{3})(\d{4})` | `$1-$2-$3` | 4 + 3 + 4 = 11 digits |
| R5 | `^[\w.]+@\w+\.\w+$` | (find only) | `^...$` forces the whole line to match; `\.` is a real dot |
| R6 | `[ \t]+$` | (empty) | Spaces/tabs right before the end of line |
| R7 | ` {2,}` | ` ` (one space) | There's a space before `{2,}` |
| R8 | `^\s*\n` | (empty) | Empty (or whitespace-only) line including its line break |
| R9 | `^(\d+),(\w+),(\w+)$` | `INSERT INTO students VALUES ($1, '$2', '$3');` | Literal text around the groups is kept |
| R10 | `System\.out\.println\((.*)\);` | `logger.info($1);` | `.` `(` `)` must be escaped to match literally |
| R11 | `<[^>]+>` | (empty) | "`<`, then anything that isn't `>`, then `>`" |
| R12 | `private (\w+) (\w+);` | `public $1 get\u$2() { return $2; }` | `\u` uppercases the next character (Sublime's Boost syntax) |

**R11 trap:** `<.*>` deletes the WHOLE line. `.*` is **greedy**: it grabs as much as possible, from the first `<` to the last `>`. Fixes: `<[^>]+>` or lazy `<.*?>`.

**R2 variant:** `^(\w+), (\w+)$` would FAIL on "Dela Cruz, Juan" and "Reyes, Jose Rizal", because `\w` doesn't match spaces. That's why `.+` is used.

## Multiple cursors
- C1: start with the cursor inside `temp` and **nothing selected**, then press Ctrl+D. Started that way, Ctrl+D only matches whole words, so `template` is skipped. If you drag-select the letters `temp` first, Ctrl+D also matches inside `template`.
- C3: result: `private int x;` and so on, one per line.

## Macros (Notepad++)
- M1 keystrokes: `Home`, `"`, `End`, `",`, `Down`
- M2 keystrokes: `Home`, `//`, `Down`, `Down`
- M3, one way: `Home`, type `map.put("`, `Ctrl+Right` (moves to just before `=`; check this, word-jumping differs by editor), `Delete` (removes `=`), type `", "`, `End`, type `");`, `Down`. If Ctrl+Right lands somewhere else, use Right arrows. Regex does it faster: find `^(\w+)=(\w+)$`, replace `map.put("$1", "$2");`

**Macro vs regex:** a macro replays **keystrokes** (position-based, good for repetitive editing steps like "every other line"). Regex matches **patterns** (content-based, good for transforming text that has a structure).

## Snippet exercise (sout)
```xml
<content><![CDATA[System.out.println(${1:message});$0]]></content>
<tabTrigger>sout</tabTrigger>
```
