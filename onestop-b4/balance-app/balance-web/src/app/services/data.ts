export const categoryType = ['Income', 'Expense']
export const balanceType = ['Income', 'Expense', 'Transfer']
const months = ['Janauary', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']

export function stringToDate(data:string) {
  let date = new Date
  const arr = data.split(' ')
  const index:number[] = months.filter(s => s == arr[0])
                             .map(s => months.indexOf(s))


  date.setFullYear(Number.parseInt(arr[1]))
  date.setMonth(index[0])
  return date
}

export function dateToString(data:Date) {
  // const dateMonth = (data.getMonth() + 1).toString()
  // const month = dateMonth.length == 1 ? '0'.concat(dateMonth) : dateMonth
  return `${months[data.getMonth()]} ${data.getFullYear()}`
}
