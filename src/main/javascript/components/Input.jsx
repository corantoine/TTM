import React from 'react'


const Input = ({
  id,
  type,
  name,
  placeholder,
  className,
  value,
  onChange,
  checked,
  useValuseAsLabel,
}) => {
  return (
    <div className="input-form">
      <label htmlFor={id}>{useValuseAsLabel ? value : name}</label>
      <input
        id={id}
        type={type}
        name={name}
        placeholder={placeholder}
        className={className}
        value={value}
        onChange={onChange}
        checked={checked}
      />
    </div>
  )
}
export default Input
