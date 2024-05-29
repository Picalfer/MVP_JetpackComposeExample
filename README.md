+-------------------------+           +-------------------------+           +-------------------------+
|         View            |           |        Presenter         |           |         Model           |
|     (MVPExampleApp)     |           |    (ItemPresenterImpl)   |           |    (Item, ItemRepository)|
+-------------------------+           +-------------------------+           +-------------------------+
|                         |           |                         |           |                         |
|  +-------------------+  |           |  +-------------------+  |           |                         |
|  | User Interface    |<------------>|   Business Logic    |<------------> |                         |
|  | (Jetpack Compose) |  |   Events  |       (MVP)         |   |  Data     |                         |
|  |                   |  |           |                     |   |  Access   |                         |
|  |   - Text Fields   |  |           |                     |   |           |                         |
|  |   - Buttons       |  |           |                     |   |           |                         |
|  |   - Lists         |  |           |                     |   |           |                         |
|  |   - Toasts        |  |           |                     |   |           |                         |
|  +-------------------+  |           |  +-------------------+  |           |                         |
|                         |           |                         |           |                         |
+-------------------------+           +-------------------------+           +-------------------------+


[View Layer]                       [Presenter Layer]                    [Model Layer]
┌───────────────┐                 ┌───────────────────────┐            ┌─────────────────────┐
│ MVPExampleApp │                 │   ItemPresenterImpl    │           │        Item         │
│  - Composables│ ── addItem ───▶│  - loadItems()        │            │                     │
│               │                 │  - addItem(item: Item)│─── addItem ─▶│    - name: String│
│               │  ◀─ showItems ─│  - setView(view: ItemView) │       │                     │
│               │  ◀─ showItemAddedMessage ──────────────────┘        │   ItemRepository    │
│               │                                                      │  - addItem(item: Item)│
│               │                                                      └─────────────────────┘
│               │
└───────────────┘
      ▲
      │
      │
┌─────┴─────┐
│ ItemView  │
│ - showItems(itemsList: List<Item>)
│ - showItemAddedMessage()
└───────────┘
