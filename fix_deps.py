with open('app/build.gradle', 'r') as f:
    content = f.read()

import re
deps_blocks = re.findall(r'dependencies\s*\{[^}]*\}', content)

if len(deps_blocks) > 1:
    first_block = deps_blocks[0]
    second_block = deps_blocks[1]

    first_inner = first_block.split('{')[1].rsplit('}', 1)[0].strip()
    second_inner = second_block.split('{')[1].rsplit('}', 1)[0].strip()

    new_deps_block = f"dependencies {{\n    {first_inner}\n    {second_inner}\n}}"

    # Replace first occurrence with the combined one
    content = content.replace(first_block, new_deps_block)
    # Remove second occurrence entirely (it will leave an empty line, which is fine)
    content = content.replace(second_block, '')

    with open('app/build.gradle', 'w') as f:
        f.write(content)
