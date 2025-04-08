import React from 'react'

const Input = ({
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
      <label htmlFor={name}>{useValuseAsLabel ? value : name}</label>
      <input
        type={type}
        name={name}
        placeholder={placeholder}
        className={className}
        value={value}
        onChange={onChange}
        checked={checked}
      ></input>
    </div>
  )
}

export default Input
